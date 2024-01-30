package com.example.fintechapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.CatmullRomInterpolator
import com.androidplot.xy.LineAndPointFormatter
import com.androidplot.xy.PanZoom
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYGraphWidget
import com.androidplot.xy.XYSeries
import com.example.fintechapp.Adapter.SpendAdapter
import com.example.fintechapp.Model.Spend
import com.example.fintechapp.databinding.ActivityStaticsBinding
import java.util.Arrays

class StaticsActivity : AppCompatActivity() {
    lateinit var binding: ActivityStaticsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spendList = mutableListOf<Spend>()
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))
        spendList.add(Spend(R.drawable.cup_hot, "$54", "Coffee"))
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))
        spendList.add(Spend(R.drawable.cup_hot, "$54", "Coffee"))
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))
        spendList.add(Spend(R.drawable.cup_hot, "$54", "Coffee"))
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))
        spendList.add(Spend(R.drawable.car_front_fill, "$545", "Taxi"))

        binding.spendRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val spendAdapter = SpendAdapter(this, spendList)
        binding.spendRv.setHasFixedSize(true)
        binding.spendRv.adapter = spendAdapter
        //grpah
        val series1Number = arrayOf<Number>(1, 5, 4, 2, 6, 10, 8, 5, 14, 7)
        val series2Number = arrayOf<Number>(1, 5, 4, 2, 6, 10, 8, 5, 14, 7)

//        val series1=SimpleXYSeries(series1Number as List)
//        val series1: XYSeries =SimpleXYSeries(Arrays.asList(*xVals), Arrays.asList(*yVals),"series 1")
        /* val series1: XYSeries =
             SimpleXYSeries(Arrays.asList(*series1Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"series 1")*/
        /*   val series1: XYSeries =
               SimpleXYSeries(Arrays.asList(*series1Number), SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED,"series 1")*/

        /*
                val xVals= arrayOf("Sat","Sun","Mon","Tue","Wed")
                val yVals= arrayOf("$00","$3000","$6000","$9000","$12000")*/
        binding.graph.setDomainBoundaries(-1,80,BoundaryMode.FIXED)

        binding.graph.graph.getLineLabelStyle(XYGraphWidget.Edge.LEFT).paint.setColor(getResources().getColor(R.color.gray600))
        binding.graph.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).paint.setColor(getResources().getColor(R.color.gray600))

        val xVals = arrayOf(1, 4, 6, 8, 14, 16, 18, 32, 46, 64)
        val yVals = arrayOf(5, 10, 15, 20, 20, 10, 40, 20, 80, 40)
        //create xy series
        val series1: XYSeries =
            SimpleXYSeries(Arrays.asList(*xVals), Arrays.asList(*yVals), "series 1")


        val series1Format = LineAndPointFormatter(Color.LTGRAY, Color.GREEN, null, null)
        series1Format.interpolationParams =
            CatmullRomInterpolator.Params(20, CatmullRomInterpolator.Type.Centripetal)
        series1Format.linePaint.strokeWidth=10f
        binding.graph.addSeries(series1, series1Format)
        PanZoom.attach(binding.graph)


    }
}