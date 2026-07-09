import { Card } from "@mui/material";
import React from "react";
import NotificationsActiveIcon from "@mui/icons-material/NotificationsActive";

const NotificationCard = () => {
  return (
    <Card
      sx={{
        bgcolor: "#FDF7FF",
        borderRadius: "16px",
        boxShadow: "0 6px 16px rgba(0,0,0,0.08)",
        border: "1px solid #E9D5FF",
      }}
      className="cursor-pointer p-5 flex items-center gap-5 hover:shadow-lg transition-all duration-300"
    >
      <NotificationsActiveIcon
        sx={{
          color: "#8B5CF6",
          fontSize: 32,
        }}
      />

      <div>
        <p className="text-green-700 font-semibold text-lg">
          🎉 Booking Confirmed
        </p>
        <h1 className="flex flex-wrap gap-2 text-gray-700">
          {[1, 1, 1, 1].map((item, index) => (
            <span
              key={index}
              className="bg-purple-100 text-purple-700 px-3 py-1 rounded-full text-sm font-medium"
            >
              Hair Cut
            </span>
          ))}
        </h1>
      </div>
    </Card>
  );
};

export default NotificationCard;
