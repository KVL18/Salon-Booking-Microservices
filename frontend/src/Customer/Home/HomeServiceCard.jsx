import React from 'react'
import HairCut from "../../assets/Hair Cut.jpg";

const HomeServiceCard = ({item}) => {
  return (
    <div className='flex justify-center items-center flex-col gap-4 rounded-lg p-4
     bg-slate-100 w-28 h-40'>

     <img className= "w-20 h-20 rounded-full" src={item.image} alt='Hair Cut'/>
     <h1 className='text-center'>{item.name}</h1>
      
    </div>
  )
}

export default HomeServiceCard
