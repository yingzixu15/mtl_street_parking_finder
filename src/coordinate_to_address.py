from geopy.geocoders import Nominatim

geolocater = Nominatim(user_agent = 'mtl_street_parking_finder')
location = geolocater.reverse('45.57600, -73.56683')
print(location.address)
print((location.latitude, location.longitude))