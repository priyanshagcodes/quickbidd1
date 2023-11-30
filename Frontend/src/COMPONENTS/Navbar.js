import React from 'react';

// filename app.js
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";

const CustomNavbar = () => {
  return (
    <>
         <nav className="navbar navbar-expand-lg bg-body-tertiary">
  <div className="container-fluid">
    <a className="navbar-brand" href="/">Quickk Bidd</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavDropdown">
      <ul className="navbar-nav">
        <li className="nav-item">
        {/* from backend */}
          <a className="nav-link active" aria-current="page" href="/">Name </a> 
        </li>
        {/* from backend */}
        <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="/">LiteCoins </a>
        </li>
      
        <li className="nav-item dropdown">
          <a className="nav-link dropdown-toggle" href="/" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Features
          </a>
          <ul className="dropdown-menu">
            <li><a className="dropdown-item" href="/">Messages</a></li>
            <li><a className="dropdown-item" href="/">Sell</a></li>
            <li><a className="dropdown-item" href="/">My Bids</a></li>
            <li><a className="dropdown-item" href="/">Sign out</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <nav className="navbar bg-body-tertiary">
  <div className="container-fluid">
    <form className="d-flex" role="search">
      <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      <button className="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
</nav>
    </>
  );
};

export default CustomNavbar;
