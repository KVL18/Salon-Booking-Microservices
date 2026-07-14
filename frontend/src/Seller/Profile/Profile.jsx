import React from 'react'
import ProfileFieldCard from './ProfileFieldCard'
import { Divider } from '@mui/material'

const Profile = () => {
  return (
    <div className='lg:px-20 lg:pb-20 space-y-20'>
    <div className='w-full lg:w-[70%]'>
    <h1 className='text-5xl font-bold pb-5'>Pablo Salon</h1>
  <section className="grid grid-cols-2 gap-3">
        <div className="col-span-2 ">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0PjscFOCzR700HF0rZJvbrnXX76JyCbCxW4csrq52Rw&s=10"
          />
        </div>
        <div className="col-span-1">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPAmdvmNxy2Ka7raJMAUlW7wDmyhMv7kX5u5Q3FMFu6Q&s=10"
          />
        </div>
        <div className="col-span-1 ">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbisWAEp4pbzVFKjZqZxjFBB4ngBv1LXzHIagakVwlag&s=10"
          />
        </div>
      </section>
    </div>
    <div className='mt-10 lg:w-[70%]'>
    <div className='flex items-center pb-3 justify-between'>
    <h1 className ="text-2xl font-bold text-gray-600">Owner Details</h1>

    </div>
    <div>
        <ProfileFieldCard keys={"Owner name"} value={"pablo"}/>
        <Divider/>
        <ProfileFieldCard keys={"Email"} value={"pablo salon"}/>
        <Divider/>
        <ProfileFieldCard keys={"role"} value={"salon owner"}/>
    
        
    </div>

    </div>
     <div className='mt-10 lg:w-[70%]'>
    <div className='flex items-center pb-3 justify-between'>
    <h1 className ="text-2xl font-bold text-gray-600">Salon Details</h1>

    </div>
    <div>
        <ProfileFieldCard keys={"salon name"} value={"pablo salon"}/>
        <Divider/>
        <ProfileFieldCard keys={"salon address"} value={"pablo salon"}/>
        <Divider/>
        <ProfileFieldCard keys={"Open Time"} value={"pablo salon"}/>
        <Divider/>
        <ProfileFieldCard keys={"Close Time"} value={"pablo salon"}/>
        
    </div>

    </div>
      
    </div>
  )
}

export default Profile
