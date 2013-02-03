/**
 * Copyright 2011-2013 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xeiam.xchart.demo.charts;

import java.util.ArrayList;
import java.util.Collection;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.SwingWrapper;
import com.xeiam.xchart.appearance.Series;
import com.xeiam.xchart.appearance.SeriesColor;
import com.xeiam.xchart.appearance.SeriesLineStyle;
import com.xeiam.xchart.appearance.SeriesMarker;

/**
 * Error bars
 * 
 * @author timmolter
 */
public class Example8 implements ExampleChart {

  public static void main(String[] args) {

    ExampleChart exampleChart = new Example8();
    Chart chart = exampleChart.getChart();
    new SwingWrapper(chart).displayChart();
  }

  @Override
  public Chart getChart() {

    // generates data
    int size = 10;
    Collection<Number> xData1 = new ArrayList<Number>();
    Collection<Number> yData1 = new ArrayList<Number>();
    Collection<Number> errorBars = new ArrayList<Number>();
    for (int i = 0; i <= size; i++) {
      xData1.add(i);
      yData1.add(10 * Math.exp(-i));
      errorBars.add(Math.random() + .3);
    }

    // Create Chart
    Chart chart = new Chart(800, 600);

    // Customize Chart
    chart.setTitleVisible(false);
    chart.setLegendVisible(false);
    chart.setAxisTitlesVisible(false);

    // Series 1
    Series series1 = chart.addSeries("10^(-x)", xData1, yData1, errorBars);
    series1.setLineColor(SeriesColor.PURPLE);
    series1.setLineStyle(SeriesLineStyle.DASH_DASH);
    series1.setMarkerColor(SeriesColor.GREEN);
    series1.setMarker(SeriesMarker.SQUARE);

    return chart;
  }

}