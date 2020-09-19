import React, { useEffect, useState } from 'react';
import './styles.css';
import Filters from '../../components/Filters';
import { barOptions, pieOptions } from './chart-options';
import Chart from 'react-apexcharts';
import Axios from 'axios';
import { buildBarSeries, getGenderChartData, getPlatformChartData } from './helpers';

type PieChartData = {
  labels: string[];
  series: number[];
}

type BarChatData = {
  x: string;
  y: number;
}

const initialPieData = {
  labels: [],
  series: []
}

const BASE_URL = 'https://sds1-claytonpereira.herokuapp.com';

const Charts = () => {
  //Estados para os graficos
  //barChartData é um parametro. setBarChatdata é uma função para atualizar a o valor de barChatdata
  const [barChartData, setBarChartData] = useState<BarChatData[]>([]);
  const [platformData, setPlatformData] = useState<PieChartData>(initialPieData);
  const [genderData, setGenderData] = useState<PieChartData>(initialPieData);

  useEffect(() => {
    async function getData() {
      const recordsResponse = await Axios.get(`${BASE_URL}/records`);
      const gamesResponse = await Axios.get(`${BASE_URL}/games`);
      //console.log(recordsResponse.data);
      //console.log(gamesResponse.data);
      const barData = buildBarSeries(gamesResponse.data, recordsResponse.data.content)
      setBarChartData(barData);

      const platformChartData = getPlatformChartData(recordsResponse.data.content)
      setPlatformData(platformChartData);

      const genderChartData = getGenderChartData(recordsResponse.data.content)
      setGenderData(genderChartData);

    }

    getData();
  }, [])

  return (
    <div className="page-container">
      <Filters link="/records" linkText="VER LISTAGEM"/>
      <div className="chart-container">
        <div className="top-related">
          <h1 className="top-related-title">
            Jogos mais votados
          </h1>
          <div className="games-container">
            <Chart
              options={barOptions}
              type="bar"
              width="800"
              height="600"
              series={[{ data: barChartData, }]}
            />
          </div>
        </div>
        <div className="charts">
          <div className="platform-chart">
            <h2 className="chart-title">Plataformas</h2>
            <Chart 
              options={{...pieOptions, labels: platformData?.labels}}
              type="donut"
              series={platformData?.series}
              width="350"
            />
          </div>
          <div className="gender-chart">
            <h2 className="chart-title">Gêneros</h2>
            <Chart 
              options={{...pieOptions, labels: genderData?.labels}}
              type="donut"
              series={genderData?.series}
              width="350"
            />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Charts;