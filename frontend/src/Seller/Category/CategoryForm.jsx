import { AddPhotoAlternate, Close } from "@mui/icons-material";
import { Button, CircularProgress, Grid, IconButton, TextField } from "@mui/material";
import { useFormik } from "formik";
import React from "react";

const CategoryForm = () => {

  const formik = useFormik({
    initialValues:{
      name:"",
      image:""
    },
    onSubmit:()=>{
      console.log(formik.values);
    }
  })
  return (
    <div className="flex justify-center items-center">
      <form onSubmit={formik.handleSubmit} className="space-y-4 p-4 w-full lg:w-1/2">
        <Grid container spacing={2}>
          <Grid className="w-24 h-24" size={{ xs: 12 }}>
            {true ? (
              <div className="relative border">
                <img
                  className="w-24 h-24"
                  src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcITfUmvD-5sEIkqiPFa6sOQhcZGdbdsWKrbig4ZXHUA&s=10"
                />
                <IconButton
                  className=""
                  color="error"
                  size="small"
                  sx={{ position: "absolute", top: 0, right: 0 }}
                >
                  <Close sx={{ fontSize: "1rem" }} />
                </IconButton>
              </div>
            ) : (
              <>
                <input
                  type="file"
                  accept="image/*"
                  id="fileInput"
                  style={{ display: "none" }}
                />
                <label className="relative" htmlFor="fileInput">
                  <span
                    className="w-24 h-24 cursor-pointer flex items-center justify-center 
                p-3 border rounded-md border-gray-400"
                  >
                    <AddPhotoAlternate className="text-gray-700" />
                  </span>
                  {false && (
                    <div
                      className="absolute left-0 right-0 top-0 bottom-0 w-24 h-24 flex
               justify-center items-center"
                    >
                      <CircularProgress />
                    </div>
                  )}
                </label>
              </>
            )}
          </Grid>
          <Grid size={12}>

          <TextField fullWidth 
            id="name"
            name="name"
            label="name"
            value={formik.values.name}
            onChange={formik.handleChange}
            required
          />

          </Grid>
          <Grid size={12}>
          <Button type="submit" variant="outlined" fullWidth sx={{py:".8rem"}}>
            Create Category
          </Button>

          </Grid>
        </Grid>
      </form>
    </div>
  );
};

export default CategoryForm;
