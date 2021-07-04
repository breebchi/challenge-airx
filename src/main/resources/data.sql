/**
 * CREATE Script for init of DB
 */

-- Create 3 flights

insert into flight (id, flight_date, iata_carrier_code, flight_number, iata_origin_code, iata_destination_code)
values (1, now(), 'AZ', '123','BRU', 'SXF');

insert into flight (id, flight_date, iata_carrier_code, flight_number, iata_origin_code, iata_destination_code)
values (2, now(), 'AZ', '2035','BRU', 'MIR');

insert into flight (id, flight_date, iata_carrier_code, flight_number, iata_origin_code, iata_destination_code)
values (3, now(), 'ZE', '8502','JFK', 'LHR');
