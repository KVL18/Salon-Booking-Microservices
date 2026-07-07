import React from 'react'
import SalonCard from './SalonCard'

const SalonList = () => {
  return (
    <div className='flex gap-5 flex-wrap'>
      {
        [1,2,3,4,5,6,7,8].map((item)=><SalonCard/>)
      }
    </div>
  )
}

export default SalonList
