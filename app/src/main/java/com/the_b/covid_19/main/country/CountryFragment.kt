package com.the_b.covid_19.main.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.the_b.covid_19.R
import com.the_b.covid_19.gone
import com.the_b.covid_19.model.CountryItem
import com.the_b.covid_19.visible
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.intentFor

class CountryFragment: Fragment(), CountryView {

    private var items: MutableList<CountryItem> = mutableListOf()
    private lateinit var presenter: CountryPresenter
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var pBarCout: ProgressBar
    private lateinit var recyler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pBarCout = find(R.id.pBarC)
        recyler = find(R.id.recycler_country)

        recyler.apply {
            countryAdapter = CountryAdapter(context, items){

                val fragment = CostumDialog.newInstance(
                    it.country.toString(),
                    it.cases.toString(),
                    it.deaths.toString(),
                    it.recovered.toString(),
                    it.active.toString(),
                    it.todayDeaths.toString(),
                    it.todayCases.toString(),
                    it.critical.toString(),
                    it.casePerOneMillion.toString())
                addFragment(fragment)
            }
            layoutManager = LinearLayoutManager(activity)
            recyler.adapter = countryAdapter
        }

        presenter = CountryPresenter(this)
        presenter.getCountryList()
    }

    private fun addFragment(fragment: DialogFragment){
        //val mDialogFragment = CostumDialog()
        val mFragment = childFragmentManager

        fragment.show(mFragment, CostumDialog::class.java.simpleName)

    }

    companion object{
        fun newInstance(): CountryFragment =
            CountryFragment()
    }

    override fun showLoading() {
        pBarCout.visible()
    }

    override fun hideLoading() {
        pBarCout.gone()
    }

    override fun showListData(data: List<CountryItem>?) {
        items.clear()
        items.addAll(data!!)
        countryAdapter.notifyDataSetChanged()
    }

    override fun errorLoading(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}