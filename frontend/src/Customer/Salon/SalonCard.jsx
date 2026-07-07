import React from 'react'
import StarIcon from '@mui/icons-material/Star';

const SalonCard = () => {
  return (
    <div className=''>
      <div className='w-56 md:w-80 rounded-md bg-slate-100'>
      <img className="w-full h-[15rem] object-cover rounded-t-md" src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRi9GHDuIKw-XTrU7lwjFH8-NtWm9pkLrFsbSju_5gs2g&s=10'/>
        <div className='p-5 space-y-2'>
            <h1 className="">Salon Name</h1>
        </div>
        <div className="text-white text-sm p-1 bg-green-700 rounded-full w-14 flex items-center justify-center gap-1 ml-5">
            4.5 <StarIcon sx={{fontSize :"16px"}}/>
        </div>
        <p>Professional haircut....</p>
        <p>Church Street ,Banglore</p>

      </div>
    </div>
  )
}

export default SalonCard
