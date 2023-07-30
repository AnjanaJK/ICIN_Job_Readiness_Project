import { ChequeBookRequestDTO } from "./cheque-book-request-dto";
import { UserPass } from "./user-pass";

export class User {
    // Declare properties
    accountNo!: string;
    userFirstName!: string;
    userLastName!: string;
    userEmail!: string;
    userPhoneNo!: string;
    userAddress!: string;
    userLocation!: string;
    userRole!: string;

    userPassword!: UserPass;

    userRequest!: ChequeBookRequestDTO;

    // address!: Address;
}
