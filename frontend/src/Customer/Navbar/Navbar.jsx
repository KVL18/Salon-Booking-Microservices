import { Avatar, Badge, Button, IconButton } from "@mui/material";
import React from "react";
import NotificationsActiveIcon from "@mui/icons-material/NotificationsActive";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const navigate = useNavigate();
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  return (
    <div className="z-50 px-6 flex items-center justify-between py-2 shadow-md">
      <div className="flex items-center gap-10">
        <h1 onClick={()=>navigate("/")}  className="cursor-pointer font-bold text-2xl">Salon service</h1>
        <div className=" flex items-center gap-5">
          <h1> Home</h1>
        </div>
      </div>
      <div className="flex items-center gap-3 md:gap-6">
        <Button variant="outlined">Become Partner</Button>
        <IconButton onClick={()=>navigate("/notifications")} >
          <Badge badgeContent={5}>
            <NotificationsActiveIcon color="primary" />
          </Badge>
        </IconButton> 
        {true ? (
          <div className="flex gap-1 items-center">
            <h1 className="text-lg font-semibold">KVL</h1>
            <IconButton
              id="basic-button"
              aria-controls={open ? "basic-menu" : undefined}
              aria-haspopup="true"
              aria-expanded={open ? "true" : undefined}
              onClick={handleClick}
            >
              <Avatar sx={{ bgcolor: "green" }}>KV</Avatar>
            </IconButton>
            <Menu
              id="basic=menu"
              anchorEl={anchorEl}
              open={open}
              onClose={handleClose}
              slotProps={{
                list: {
                  "aria-labelledby": "bacic-button",
                },
              }}
            >
              <MenuItem onClick={handleClose}>Profile</MenuItem>
              <MenuItem onClick={()=>{
                navigate("/bookings")
                handleClose()
              }}>My Bookings</MenuItem>
              <MenuItem onClick={handleClose}>Logout</MenuItem>
            </Menu>
          </div>
        ) : (
          <IconButton>
            <AccountCircleIcon sx={{ fontSize: "45px", color: "green" }} />
          </IconButton>
        )}
      </div>
    </div>
  );
};

export default Navbar;
