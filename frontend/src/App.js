import logo from './logo.svg';
import './App.css';
import { Button, ThemeProvider } from '@mui/material';
import greenTheme from './theme/greenTheme';
import Home from './Customer/Home/Home';
import SalonDetails from './Customer/Salon/Salon Details/SalonDetails';
import Bookings from './Customer/Booking/Bookings';
import Notification from './Customer/Notification/Notifications';
import Navbar from './Customer/Navbar/Navbar';
import { Route,Routes } from 'react-router-dom';
import SalonDashboard from './Seller/SalonDashboard';
import Notifications from './Customer/Notification/Notifications';
import CustomerRoutes from './Routes/CustomerRoutes';


function App() {
  return (
    
    <ThemeProvider theme={greenTheme}>
       
          <Routes>
            <Route path="/salon-dashboard/*" element={<SalonDashboard/>}/>
            <Route path="*" element={<CustomerRoutes/>}/>
          </Routes>
    </ThemeProvider>
    
  
  );
}

export default App;
