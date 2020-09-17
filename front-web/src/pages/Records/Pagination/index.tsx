import React from 'react';
import './styles.css';

//este componente irá reeber uma type Props (Parametros)
type Props = {
    totalPages?: number;
    goToPage: Function; //metodo
    activePage: number;
}

const Pagination = ({ totalPages = 0, goToPage, activePage }: Props) => {
    //gera os botoes dinamicamente
    const paginationItems = Array.from(Array(totalPages).keys());
    return (
        <div className="pagination-container">
            {paginationItems.map(item => (
                <button
                    key={item}
                    className={`pagination-item ${activePage === item ? 'active' : 'inactive'}`}//concatenando
                    onClick={() => goToPage(item)}
                >
                    {item + 1}
                </button>
            ))}

           {/* <button className="pagination-item active">
                x
            </button>
            <button className="pagination-item inactive">
                y
            </button> */}

        </div>
    );
}

export default Pagination;