export class ChequeBookRequestDTO {

    accountNo: string;
    accountType: string;
    description: string;

    constructor(accountNo: string, accountType: string, description: string) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.description = description;
    }
}
