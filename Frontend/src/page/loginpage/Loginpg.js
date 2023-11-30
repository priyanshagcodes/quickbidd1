import React from 'react';
import './Loginpgstyl.css';
import Quick_Bidd from '../../Pictures/Quick_Bidd.jpg';
import img2 from '../../Pictures/img2.jpg' ;
import img3 from '../../Pictures/creators.png';
import LoginButton from '../../COMPONENTS/LoginButton';

export default function Loginpg() {
  return (
    <>
      <div>
        <img className='img1' src={Quick_Bidd} alt="" />
      </div>
      <div>
        <img className='img2' src={img2} alt="" />
      </div>
      <div>
        <img className='img3' src={img3} alt="" />
      </div>
      
      <LoginButton/>
    </>
  );
}

