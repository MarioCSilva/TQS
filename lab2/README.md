2/
b) Consider that we want to verify the AddressResolver#findAddressForLocation, which invokes a remote geocoding service, available in a REST interface, passing the site coordinates.
Which is the service to mock?

AddressResolver requires an external service from a Rest interface, for that reason the interface remote geocoding service should be mocked in order to isolate the dependencies of the AddressResolver.

