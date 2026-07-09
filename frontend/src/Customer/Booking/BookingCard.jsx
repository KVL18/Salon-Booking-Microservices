import ArrowRightAltIcon from "@mui/icons-material/ArrowRightAlt";
import AccessTimeIcon from "@mui/icons-material/AccessTime";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import { Button } from "@mui/material";
import React from "react";

const BookingCard = () => {
  return (
    <div className="bg-white rounded-xl shadow-md border p-6 flex flex-col md:flex-row justify-between items-center gap-6 hover:shadow-lg transition-all duration-300">

      {/* Left Section */}
      <div className="flex-1 space-y-4">

        <h1 className="text-2xl font-bold text-gray-800">
          Monika Salon
        </h1>

        <div>
          <p className="font-semibold text-gray-700 mb-2">
            Services
          </p>

          <ul className="list-disc list-inside text-gray-600 space-y-1">
            <li>Hair Cut</li>
            <li>Massage</li>
            <li>Hair Color</li>
          </ul>
        </div>

        <div className="space-y-2 text-gray-700">

          <div className="flex items-center gap-2">
            <CalendarMonthIcon fontSize="small" />
            <span>12 Dec 2026</span>
          </div>

          <div className="flex items-center gap-2">
            <AccessTimeIcon fontSize="small" />
            <span>
              12:30 PM
              <ArrowRightAltIcon
                sx={{ fontSize: 18 }}
              />
              1:30 PM
            </span>
          </div>

        </div>

      </div>

      {/* Right Section */}
      <div className="flex flex-col items-center gap-4">

        <img
          className="w-32 h-32 object-cover rounded-xl"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcqGEO-NcxMoqD2W6soFU7GVCD23ZeVwFrc6qOG-1ZkA&s=10"
          alt="Salon"
        />

        <h2 className="text-2xl font-bold text-green-600">
          ₹249
        </h2>

        <Button
          variant="contained"
          color="error"
          fullWidth
        >
          Cancel Booking
        </Button>

      </div>

    </div>
  );
};

export default BookingCard;