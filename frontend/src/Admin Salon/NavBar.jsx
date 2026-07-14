import { Menu, NotificationsActive } from '@mui/icons-material'
import { Badge, Drawer, IconButton } from '@mui/material'
import React from 'react'

const NavBar = ({DrawerList}) => {
    const [open ,setopen] = React.useState(false);
    const toogleDrawer=(newOpen)=>()=>{
        setopen(newOpen);
    };

  return (
    <div className='h-[10vh] flex items-center justify-between px-5 border-b'>

    <div className=' flex items-center gap-3'>


    <IconButton onClick={toogleDrawer(true)}>
        <Menu color='primary'/>
    </IconButton>
    <h1 className='text-xl cursor-pointer font-bold'>Salon Booking</h1>

    </div>

    <IconButton>
        <Badge color='secondary'>
            <NotificationsActive color='primary'/>
        </Badge>
    </IconButton>

    <Drawer open={open} onClose={toogleDrawer(false)}>
        <DrawerList toogleDrawer={toogleDrawer}/>
    </Drawer>
      
    </div>
  )
}

export default NavBar
