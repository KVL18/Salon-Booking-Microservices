import logo from './logo.svg';
import './App.css';
import { Button, ThemeProvider } from '@mui/material';
import greenTheme from './theme/greenTheme';
import Home from './Customer/Home/Home';
import SalonDetails from './Customer/Salon/Salon Details/SalonDetails';
import Bookings from './Customer/Booking/Bookings';

function App() {
  return (
    
    <ThemeProvider theme={greenTheme}>
          {/* <Home /> */}
          {/* <SalonDetails/>  */}
          <Bookings/>
    </ThemeProvider>
    
  
  );
}

export default App;
