package com.the_b.covid_19.main.country

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.the_b.covid_19.R
import org.jetbrains.anko.support.v4.find

class CostumDialog: DialogFragment() {

    private lateinit var countryName: TextView
    private lateinit var cases: TextView
    private lateinit var deaths: TextView
    private lateinit var recovered: TextView
    private lateinit var active: TextView
    private lateinit var critical: TextView
    private lateinit var todayCases: TextView
    private lateinit var todayDeaths: TextView
    private lateinit var casesPerMillion: TextView
    private lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.ThemeOverlay_AppCompat_Dialog
        setStyle(style, theme)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.costum_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryName = find(R.id.country)
        cases = find(R.id.cases)
        deaths = find(R.id.deaths)
        recovered = find(R.id.recovered)
        active = find(R.id.active)
        critical = find(R.id.critical)
        todayCases = find(R.id.today_cases)
        todayDeaths = find(R.id.today_deaths)
        casesPerMillion = find(R.id.cases_per)
        btnOk = find(R.id.btn_ok)

        btnOk.setOnClickListener {
            dismiss()
        }

        countryName.text = arguments!!.getString("country")
        cases.text =  arguments!!.getString("cases")
        deaths.text = arguments!!.getString("deaths")
        recovered.text = arguments!!.getString("recovered")
        active.text = arguments!!.getString("active")
        critical.text = arguments!!.getString("critical")
        todayDeaths.text = arguments!!.getString("todayDeaths")
        todayCases.text = arguments!!.getString("todayCases")
        casesPerMillion.text = arguments!!.getString("casesPer")
    }

    companion object{
        fun newInstance(country: String,
                        cases: String,
                        deaths: String,
                        recovered: String,
                        active: String,
                        todayDeaths: String,
                        todayCases: String,
                        critical: String,
                        casePer: String): CostumDialog {
            val f = CostumDialog()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("country", country)
            args.putString("cases", cases)
            args.putString("deaths", deaths)
            args.putString("recovered", recovered)
            args.putString("active", active)
            args.putString("todayDeaths", todayDeaths)
            args.putString("todayCases", todayCases)
            args.putString("critical",critical)
            args.putString("casesPer", casePer)
            f.arguments = args

            return f
        }
    }
}