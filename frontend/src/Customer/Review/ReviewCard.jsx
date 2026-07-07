import React from "react";
import Grid from "@mui/material/Grid";
import { Avatar, Box, IconButton, Rating } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";

const ReviewCard = () => {
  return (
    <div className="flex justify-between">
      <div className="w-[80%]">
        <Grid container >
          <Grid size={1.5}>
            <Box>
              <Avatar
                className="text-white"
                sx={{
                  width: 56,
                  height: 56,
                  bgcolor: "#9155FD",
                }}
              >
                A
              </Avatar>
            </Box>
          </Grid>
          <Grid size={9}>
            <div className="space-y-1">
              <p className="font-semibold text-lg">Code wit kvl</p>
              <p className="opacity-70">2026-12-01T09:00:00Z</p>
            </div>
            <div>
              <Rating readOnly name="half-rating" value={4.5} precision={0.5} />
            </div>
            <p>this service</p>
          </Grid>
        </Grid>
      </div>

      <IconButton>
        <DeleteIcon sx={{ color: "red" }} />
      </IconButton>
    </div>
  );
};

export default ReviewCard;
