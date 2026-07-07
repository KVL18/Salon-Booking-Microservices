import FiberManualRecordIcon from "@mui/icons-material/FiberManualRecord";
import { Button } from "@mui/material";
import React from "react";

const ServiceCard = () => {
  return (
    <div className="w-full">
      <div className="flex gap-5 items-center justify-between">
        <div className="space-y-1 w-[60%]">
          <h1 className="text-2xl font-semibold"> Man Beard</h1>
          <p className="text-grey-500 text-sm">Style men beard</p>

          <div className="flex items-center gap-3">
            <p>₹399</p>
            <FiberManualRecordIcon sx={{ fontSize: "10px", color: "grey" }} />
            <p>30 min</p>
          </div>
        </div>
        <div className="space-y-3">
          <img
            className="w-32 h-32 object-cover rounded-md"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmbzc3e_eQsUZIATpTdnxNih1SG8Vs60qgdD3nfSvvug&s=10"
          />
          <Button fullWidth variant="outlined">
            Add
          </Button>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
