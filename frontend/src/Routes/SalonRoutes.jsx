import React from 'react'
import { Route, Routes } from 'react-router-dom'
import ServiceForm from  '../Seller/Services/ServiceForm'
import Notifications from '../Customer/Notification/Notifications'
import Payment from '../Seller/Payment/Payment'
import BookingTable from '../Seller/Booking/BookingTable'
import TransactionTable from '../Seller/Transaction/TransactionTable'
import HomePage from '../Seller/Home/HomePage'
import Category from '../Seller/Category/Category'
import ServiceTable from '../Seller/Services/ServiceTable'
import Profile from '../Seller/Profile/Profile'


const SalonRoutes = () => {
  return (
    <div>
       <Routes>
          <Route path="/" element={<HomePage/>}/>
          <Route path="/services" element={<ServiceTable/>}/>
          <Route path="/add-services" element={<ServiceForm/>}/>
          <Route path="/bookings" element={<BookingTable/>}/>
          <Route path="/category" element={<Category/>}/>
          <Route path="/transaction" element={<TransactionTable/>}/>
          <Route path="/notifications" element={<Notifications/>}/>
          <Route path="/payment" element={<Payment/>}/>
          <Route path="/account" element={<Profile/>}/>
        </Routes>
    </div>
  )
}

export default SalonRoutes
