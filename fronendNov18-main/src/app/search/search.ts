export interface Search {

paymentlatePayment: any;
paymentisLatePayment: any;
PolicyPolicyAmount: any;
policypolicyType: any;

  customerId: string;
  customerFirstName: string;
  customerLastName: string;
  customerAge:string;
  customerEmail: string;
  customerDateOfBirth: Date;
  customerPhoneNumber: string;

  policyId: string;
  policyNumber: string;
  policyType: string;
  policyStartDate: Date;
  policyEndDate: Date;
  policyActive: boolean;
  policyAmount:string;

  paymentId: string;
  paymentDate: Date;
  amountPaid: number;
  latePayment: boolean;

  claimId: string;
  claimAmount: number;
  claimStatus: string;
  policyTypeFilter?: string;

}