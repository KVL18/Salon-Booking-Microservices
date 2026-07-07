import React from 'react'
import { Box, Button, InputLabel, Rating, TextField } from '@mui/material'
import { Formik, useFormik } from 'formik'


const CreateReviewForm = () => {
    const formik = useFormik({
        initialValues: {
            reviewText: '',
            reviewRating: 0
        },
        onSubmit: (values) => {
            // Handle form submission
            console.log('Form submitted:', values);
        }
    });

  return (
    <Box
    component={"form"}
    onSubmit={formik.handleSubmit}
    sx={{mt:3}}
    className="space-y-5 w-full lg:w-1/2"
    >
    <TextField
        fullWidth
        id="reviewText"
        name="reviewText"
        label="Write your review"
        multiline
        variant='outlined'
        rows={4}
        value={formik.values.reviewText}
        onChange={formik.handleChange}
    />
    <div className="space-y-2">
    <InputLabel>Rating</InputLabel>
    <Rating id="reviewRating" name="reviewRating"
     value={formik.values.reviewRating}
     onChange={(event, newValue) => {
        formik.setFieldValue('reviewRating', newValue);
      }}
      precision={0.5} />

    </div>
    <Button variant='contained' color='primary' type='submit'>Submit Review</Button>
    </Box>
  )
};

export default CreateReviewForm
