import React from "react";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import { Stack } from "@mui/system";

export default function About() {
    return (
        <Box sx={{ backgroundColor: 'white', borderRadius: 2, width: '100%', maxWidth: 600,marginTop:'7%' }}>
            <Stack sx={{ m: 2 }}>
                <Typography align="left" variant="h2" gutterBottom>
                    About us
                </Typography>
                <Typography align="left" variant="body1" gutterBottom>
                We connect the world to, and through, our global hub in world.
                 We operate modern, efficient and comfortable aircraft, and our culturally diverse workforce delivers 
                 award-winning services to our customers across six continents every day.
                </Typography>
            
            </Stack>
        </Box>
    )
}