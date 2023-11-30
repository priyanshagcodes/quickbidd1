import React from "react";
import "./Bidcard.css";

const Bidcard = ({ bidTime, currentValue }) => {
  return (
    <>
    <div className="bid-card">
      <h2>Bid Time</h2>
      <p>{bidTime}</p>
      <h2>Current Value</h2>
      <p>{currentValue} LC</p>
      <button className="card-button">Bid</button>
    </div>

    </>
  );
};

export default Bidcard;