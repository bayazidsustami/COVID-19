package com.the_b.covid_19.main.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.the_b.covid_19.R
import com.the_b.covid_19.gone
import com.the_b.covid_19.model.GetGlobal
import com.the_b.covid_19.visible
import org.jetbrains.anko.support.v4.find

class GlobalFragment: Fragment(), GlobalView {

    private lateinit var presenter: GlobalPresenter
    private lateinit var progress: ProgressBar
    private lateinit var cases: TextView
    private lateinit var deaths: TextView
    private lateinit var recovered: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress = find(R.id.pBar)
        cases = find(R.id.cases)
        deaths = find(R.id.deaths)
        recovered = find(R.id.recovered)

        presenter = GlobalPresenter(this)
        presenter.getData()
    }

    companion object{
        fun newInstance(): GlobalFragment = GlobalFragment()
    }

    override fun showLoading() {
        progress.visible()
    }

    override fun hideLoading() {
        progress.gone()
    }

    override fun showData(data: GetGlobal?) {
        cases.text = data!!.cases
        deaths.text = data.deaths
        recovered.text = data.recovered
    }

    override fun errorLoading(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}