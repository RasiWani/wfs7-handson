export const USERNAME : string = "Alexandar"; // simple type

export const USER : any = {"name":"Bruce", "dob":"1998-10-15"};

export const USER_ARRAY : any = [
    {"name":"Charles", "dob":"2000-10-15"}, 
    {"name":"David", "dob":"1998-11-18"}, 
    {"name":"Edward", "dob":"2001-12-19"}
];

export const EMP_ARRAY : any = [
    {"id":101,"name":"Charles","salary":50000, "dob":"2000-10-15"}, 
    {"id":102,"name":"David","salary":70000, "dob":"1998-11-18"}, 
    {"id":103,"name":"Edward", "salary":45000,"dob":"2001-12-19"}
];

// you can import variables also using
// `import {username, user, userArray} from ./mock`