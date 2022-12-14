import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';

import Avatar from '@mui/material/Avatar';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import AirplaneTicketIcon from '@mui/icons-material/AirplaneTicket';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Paper from '@mui/material/Paper';
import { Box, Link, Typography } from '@mui/material';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';

import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';

const Alert = React.forwardRef(function Alert(props, ref) {
    return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});

function BookFlight() {
    const location = useLocation()
    const [open, setOpen] = React.useState(false);

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }
        setOpen(false);
    };

    const [inputs, setInputs] = useState({
        firstName: '',
        lastName: '',
        gender: '',
        email: '',
        phoneNo: '',
        requiredSeats: '',
    });

    const handleChange = (prop) => (event) => {
        setInputs({ ...inputs, [prop]: event.target.value });
    };

    const handleSubmit = event => {
        const userObject = {
            firstName: inputs.firstName,
            lastName: inputs.lastName,
            gender: inputs.gender,
            email: inputs.email,
            phoneNumber: inputs.phoneNo,
            requiredNumberOfSeats: inputs.requiredSeats,
            flightId: location.state.flight.id
        }
        console.log(userObject);

        axios.post('http://localhost:8080/booking/book', userObject)
            .then((res) => {
                console.log(res.data)
                setOpen(true);
            }).catch((error) => {
                console.log(error)
            });
        event.preventDefault()
    }

    return (
        <Box component={Paper} elevation={5} sx={{ backgroundColor: 'white', borderRadius: 2 }}>
            <form onSubmit={handleSubmit}  style={{"marginTop":"5em"}}>
                <Stack sx={{ m: 2 }} alignItems='center' direction='column' spacing={2}>
                    <Stack sx={{ m: 1 }} alignItems='center' direction='column' spacing={0}>
                        <Avatar sx={{ m: 1, bgcolor: 'primary.main' }}>
                            <AirplaneTicketIcon fontSize='medium' />
                        </Avatar>
                        <Typography component='h1' variant='h5' color='black' >Book Flights</Typography>
                    </Stack>
                    <Stack sx={{ m: 1, width: 'stretch' }} alignItems='center' direction='row' spacing={2}>
                        <TextField
                            required
                            fullWidth
                            autoFocus
                            id="outlined-required-firstName"
                            label="first name"
                            name='firstName'
                            value={inputs.firstName}
                            onChange={handleChange('firstName')}
                        />
                        <TextField
                            required
                            fullWidth
                            id="outlined-required-lastName"
                            label="last name"
                            name='lastName'
                            value={inputs.lastName}
                            onChange={handleChange('lastName')}
                        />
                    </Stack>
                    <TextField
                        required
                        fullWidth
                        id="outlined-required-email"
                        label="email"
                        name='email'
                        value={inputs.email}
                        inputProps={{ pattern: '[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$' }}
                        onChange={handleChange('email')}
                    />
                    <TextField
                        required
                        fullWidth
                        id="outlined-required-phoneNo"
                        label="phone number"
                        name='phoneNo'
                        value={inputs.phoneNo}
                        inputProps={{ pattern: '[0-9]{10}$' }}
                        onChange={handleChange('phoneNo')}
                    />
                    <Stack alignItems='center' direction='row' spacing={2}>
                        <FormControl>
                            <FormLabel sx={{ fontSize: "small" }} id="demo-row-radio-buttons-group-label">Gender</FormLabel>
                            <ToggleButtonGroup
                                color="primary"
                                size='small'
                                value={inputs.gender}
                                exclusive
                                onChange={handleChange('gender')}
                                aria-label="gender"
                            >
                                <ToggleButton value="Male">Male</ToggleButton>
                                <ToggleButton value="Female">Female</ToggleButton>
                                <ToggleButton value="Other">Other</ToggleButton>
                            </ToggleButtonGroup>
                        </FormControl>
                        <FormControl sx={{ width: '20ch' }} variant="outlined">
                            <InputLabel htmlFor="outlined-adornment-password">passengers</InputLabel>
                            <OutlinedInput
                                id="outlined-adornment-password"
                                required
                                fullWidth
                                type='number'
                                value={inputs.requiredSeats}
                                inputProps={{ min: 1, max: 4 }}
                                onChange={handleChange('requiredSeats')}
                                label="required seats"
                            />
                        </FormControl>
                    </Stack>
                    <Button variant='contained' type='submit'>Book Flight</Button>
                    <Stack direction='row' spacing={1}>
                        <Link href='/' variant='caption'>Go back</Link>
                    </Stack>
                    <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
                        <Alert onClose={handleClose} severity="success" sx={{ width: '100%' }}>
                            Flight booked successfully!
                        </Alert>
                    </Snackbar>
                </Stack>
            </form>
        </Box>
    )

}

export default BookFlight;