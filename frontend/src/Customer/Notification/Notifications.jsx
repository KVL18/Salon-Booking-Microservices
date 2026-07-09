import React from 'react'
import NotificationCard from './NotificationCard'

const Notifications = () => {
  return (
    <div className="px-5 md:flex flex-col items-center mt-10 min-h-screen bg-gradient-to-br from-purple-50 via-pink-50 to-white ">
        <h1 className="text-4xl font-bold text-gray-800 mb-8">
          Notifications
        </h1>

        <div className="space-y-6">
          <NotificationCard/>
        </div>



    </div>
  )
}

export default Notifications
