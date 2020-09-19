import React, { useEffect, useState } from 'react';
import axios from 'axios'; //ponte para conectar o back-end via http
import './styles.css';
import { RecordsResponse } from './types';
import { formatDate } from './helpers';
import Pagination from './Pagination';
import Filters from '../../components/Filters';


const BASE_URL = 'https://sds1-claytonpereira.herokuapp.com';

const Records = () => {
  //criando um stado interno para o componente que viabiliza o a listagem dados
  //useState é um HOOK
  const [recordResponse, setRecordsResponse] = useState<RecordsResponse>();
  const [activePage, setActivePage] = useState(0);
  
  useEffect(() => {
    //console.log('Component Started!');
    axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
    .then(response => setRecordsResponse(response.data));
  }, [activePage]);

  const handlePageChange = (index: number) => {
    setActivePage(index);
  }

  return (
    <div className="page-container">
      <Filters link="/charts" linkText="VER GRÁFICO" />

      <table className="records-table" cellPadding="0" cellSpacing="0">
        <thead>
          <tr>
            <th>INSTANT</th>
            <th>NOME</th>
            <th>IDADE</th>
            <th>PLATAFORMA</th>
            <th>GÊNERO</th>
            <th>TÍTULO DO GAME</th>  
          </tr>
        </thead>
        <tbody>
          {recordResponse?.content.map(record => (
            <tr key={record.id}>
              <td>{formatDate(record.moment)}</td>
              <td>{record.name}</td>
              <td>{record.age}</td>
              <td className="text-secondary">{record.gamePlatform}</td>
              <td>{record.genreName}</td>
              <td className="text-primary">{record.gameTitle}</td>
          </tr>
          ))}
        </tbody>
      </table>

      <Pagination
        activePage={activePage}
        goToPage={handlePageChange}
        totalPages={recordResponse?.totalPages}
      />
  
    </div>
  );
}

export default Records;