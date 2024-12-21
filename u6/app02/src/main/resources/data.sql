INSERT INTO myusers (
    name,
    usrcode, 
    password, 
    isactive
) values (
    'customer',
    'customer',
    '$2a$04$c8PEcgiCk1Oa635CtkQ8f.8GbYkyDWVLjWLEJ6ZbKK1Gj.pRm7MXe',
    1
),(
    'staff',
    'staff',
    '$2a$04$c8PEcgiCk1Oa635CtkQ8f.8GbYkyDWVLjWLEJ6ZbKK1Gj.pRm7MXe',
    1
),(
    'admin',
    'admin',
    '$2a$04$c8PEcgiCk1Oa635CtkQ8f.8GbYkyDWVLjWLEJ6ZbKK1Gj.pRm7MXe',
    1
);

INSERT INTO myroles (
    usrcode, 
    roles
) values (
    'customer', 
    'ROLE_CUSTOMER'
),(
    'staff', 
    'ROLE_STAFF'
),(
    'admin', 
    'ROLE_STAFF'
),(
    'admin', 
    'ROLE_ADMIN'
);