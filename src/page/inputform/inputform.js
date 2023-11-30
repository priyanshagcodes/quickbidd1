import React, { useState } from 'react';
import './inputform.css';
import CustomNavbar from '../../COMPONENTS/Navbar';
import axios from 'axios'
function Inputform() {
 const [itemName, setItemName] = useState('');
 const [itemType, setItemType] = useState('');
 const [description, setDescription] = useState('');
 const [startingBid, setStartingBid] = useState(0);

 const [image, setImage] = useState(null);

 const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    const formData = new FormData();
    formData.append('itemName', itemName);
    formData.append('itemType', itemType);
    formData.append('description', description);
    formData.append('startingBid', startingBid);
    formData.append('image', image);

    // Adjust the URL to your server endpoint
    const response = await axios.post('http://localhost:8080/spi/products/create/', formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });

    console.log("Item registered successfully");

    // Handle the response from the server as needed
  } catch (error) {
    console.error('Error submitting form');
    // Handle errors appropriately
  }
};


 const handleImageChange = (e) => {
    if (e.target.files[0]) {
      setImage(e.target.files[0]);
    }
 };

 return (
    <>
    <CustomNavbar></CustomNavbar>
    <div className="App">
      <h1>Bidding System</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Item Name:
          <input type="text" value={itemName} onChange={(e) => setItemName(e.target.value)} required />
        </label>
        <br />
        <label>
          Item Type:
          <input type="text" value={itemType} onChange={(e) => setItemType(e.target.value)} required />
        </label>
        <br />
        <label>
          Description:
          <textarea value={description} onChange={(e) => setDescription(e.target.value)} required />
        </label>
        <br />
        <label>
          Starting Bid:
          <input type="number" value={startingBid} onChange={(e) => setStartingBid(e.target.value)} required />
        </label>
        <br />
      
        <br />
        <label>
          Upload Images / Videos:
          <input type="file" onChange={handleImageChange} />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
    </>
 );
}

export default Inputform
;