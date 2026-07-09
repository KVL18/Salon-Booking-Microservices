import React from "react";
import BookingCard from "./BookingCard";

const Bookings = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-purple-50 via-pink-50 to-white py-10 px-5">

      <div className="max-w-3xl mx-auto">

        <h1 className="text-4xl font-bold text-gray-800 mb-8">
          My Bookings 💇‍♀️
        </h1>

        <div className="space-y-6">
          <BookingCard />
        </div>

      </div>

    </div>
  );
};

export default Bookings;