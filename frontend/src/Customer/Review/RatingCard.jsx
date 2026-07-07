import React from "react";
import { Box, Grid, LinearProgress, Rating } from "@mui/material";

const RatingCard = () => {
  return (
    <div className="border p-5 rounded-md">
      <div className="flex items-center space-x-3 pb-10">
        <Rating readOnly name="half-rating" value={4.5} precision={0.5} />
        <p className="m-0 opacity-60">23456</p>
      </div>
      <Box>
        <Grid container  alignItems="center">
          <Grid size={3} className="flex items-center">
            <p className="m-0">Excellent</p>
          </Grid>

          <Grid size={6} className="flex items-center">
            <LinearProgress
              variant="determinate"
              color="success"
              value={40}
              sx={{
                height: 7,
                width: "100%",
                bgcolor: "#d0d0d0",
                borderRadius: 4,
              }}
            />
          </Grid>

          <Grid size={2} className="flex items-center justify-end">
            <p className="m-0 opacity-50">1234</p>
          </Grid>
        </Grid>
        <Grid container alignItems="center">
          <Grid size={3} className="flex items-center">
            <p className="m-0">Very Good</p>
          </Grid>

          <Grid size={6} className="flex items-center">
            <LinearProgress
              variant="determinate"
              color="success"
              value={50}
              sx={{
                height: 7,
                width: "100%",
                bgcolor: "#d0d0d0",
                borderRadius: 4,
              }}
            />
          </Grid>

          <Grid size={2} className="flex items-center justify-end">
            <p className="m-0 opacity-50">1234</p>
          </Grid>
        </Grid>
        <Grid container  alignItems="center">
          <Grid size={3} className="flex items-center">
            <p className="m-0">Good</p>
          </Grid>

          <Grid size={6} className="flex items-center">
            <LinearProgress
              variant="determinate"
              color="warning"
              value={30}
              sx={{
                height: 7,
                width: "100%",
                bgcolor: "#d0d0d0",
                borderRadius: 4,
              }}
            />
          </Grid>

          <Grid size={2} className="flex items-center justify-end">
            <p className="m-0 opacity-50">1234</p>
          </Grid>
        </Grid>
        <Grid container  alignItems="center">
          <Grid size={3} className="flex items-center">
            <p className="m-0">Average</p>
          </Grid>

          <Grid size={6} className="flex items-center">
            <LinearProgress
              variant="determinate"
              color="success"
              value={20}
              sx={{
                height: 7,
                width: "100%",
                bgcolor: "#d0d0d0",
                borderRadius: 4,
              }}
            />
          </Grid>

          <Grid size={2} className="flex items-center justify-end">
            <p className="m-0 opacity-50">1234</p>
          </Grid>
        </Grid>
        <Grid container alignItems="center"> 
          <Grid size={3} className="flex items-center">
            <p className="m-0">Poor</p>
          </Grid>

          <Grid size={6} className="flex items-center">
            <LinearProgress
              variant="determinate"
              color="error"
              value={10}
              sx={{
                height: 7,
                width: "100%",
                bgcolor: "#d0d0d0",
                borderRadius: 4,
              }}
            />
          </Grid>

          <Grid size={2} className="flex items-center justify-end">
            <p className="m-0 opacity-50">1234</p>
          </Grid>
        </Grid>
      </Box>
    </div>
  );
};

export default RatingCard;
