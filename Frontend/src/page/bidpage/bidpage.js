import React from "react";
import "./bidpage.css";
import Bidcard from "./../../COMPONENTS/Bidcard";
 import  Navbar from "./../../COMPONENTS/Navbar";
const BidPage = () => {
  const bidCards = [
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
    { bidTime: "xx:xx:xx:xx", currentValue: "xxxx" },
  ];

  return (
    <>
    <Navbar/>
    <div className="App">
      <div className="card-container">
        {bidCards.map((card, index) => (
          <Bidcard
            key={index}
            bidTime={card.bidTime}
            currentValue={card.currentValue}
          ></Bidcard>
        ))}
      </div>
    </div>

    </>
  );
};

export default BidPage;



// import React, { useState } from "react";
// import "./bidpage.css";
// import Bidcard from "./../../COMPONENTS/Bidcard";
// import  Navbar from "./../../COMPONENTS/Navbar";

// const BidPage = () => {
//   const [numCards, setNumCards] = useState(6); // Default number of cards

//   const handleInputChange = (e) => {
//     const value = parseInt(e.target.value, 10);
//     setNumCards(isNaN(value) ? 0 : value);
//   };

//   // Generate an array with a length equal to numCards
//   const cardArray = Array.from({ length: numCards }, (_, index) => index);

//   return (
//     <>
//     <Navbar></Navbar>
//     <div className="App">
//       <div>
//         <label htmlFor="numCardsInput">Enter the number of cards:</label>
//         <input
//           type="number"
//           id="numCardsInput"
//           value={numCards}
//           onChange={handleInputChange}
//         />
//       </div>

//       <div className="card-container">
//         {cardArray.map((cardIndex) => (
//           <Bidcard
//             key={cardIndex}
//             bidTime={'xx:xx:xx:xx'}
//             currentValue={'xxxx'}
//           />
//         ))}
//       </div>
//     </div>
//     </>
//   );
// };

// export default BidPage;

// import React, { useState, useEffect } from "react";
// import "./bidpage.css";
// import Bidcard from "./../../COMPONENTS/Bidcard";

// const BidPage = () => {
//   const [numCards, setNumCards] = useState(6); // Default number of cards
//   const [bidData, setBidData] = useState([]);

//   const handleInputChange = (e) => {
//     const value = parseInt(e.target.value, 10);
//     setNumCards(isNaN(value) ? 0 : value);
//   };

//   useEffect(() => {
//     const fetchData = async () => {
//       try {
//         // Replace 'your-backend-endpoint' with the actual endpoint
//         const response = await fetch('your-backend-endpoint');
//         const data = await response.json();
//         setBidData(data);
//       } catch (error) {
//         console.error("Error fetching bid data:", error);
//       }
//     };

//     fetchData();
//   }, [numCards]); // Fetch data whenever numCards changes

//   return (
//     <div className="App">
//       <div>
//         <label htmlFor="numCardsInput">Enter the number of cards:</label>
//         <input
//           type="number"
//           id="numCardsInput"
//           value={numCards}
//           onChange={handleInputChange}
//         />
//       </div>

//       <div className="card-container">
//         {bidData.slice(0, numCards).map((bid, index) => (
//           <Bidcard
//             key={index}
//             bidTime={bid.bidTime} // Assuming bidTime is a property in your data
//             currentValue={bid.currentValue} // Assuming currentValue is a property in your data
//           />
//         ))}
//       </div>
//     </div>
//   );
// };

// export default BidPage;