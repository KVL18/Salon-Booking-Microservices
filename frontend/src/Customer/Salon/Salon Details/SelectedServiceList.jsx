import { IconButton } from '@mui/material'
import React from 'react'
import CloseIcon from '@mui/icons-material/Close';

const SelectedServiceList = () => {
  return (
    <div className='my-5 space-y-2'>
     {[1,1,1,1].map((item)=> <div className='py-2 px-4 rounded-md bg-slate-100 flex justify-between items-center'>
      <h1 className='font-thin'>Man Beard</h1>
      <p>rs 399</p>
      <IconButton>
        <CloseIcon sx={{color:"grey"}}/>
      </IconButton>

      </div>) }
    </div>
  )
}

export default SelectedServiceList
