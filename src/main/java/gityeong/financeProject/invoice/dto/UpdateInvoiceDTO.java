package gityeong.financeProject.invoice.dto;

import java.math.BigDecimal;

public class UpdateInvoiceDTO {

        private int invoiceId;
        private String description;
        private BigDecimal totalDue;
        private boolean invApprovalStatus;

        // Getters and setters

        public int getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(int invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(BigDecimal totalDue) {
            this.totalDue = totalDue;
        }

        public boolean isInvApprovalStatus() {
            return invApprovalStatus;
        }

        public void setInvApprovalStatus(boolean invApprovalStatus) {
            this.invApprovalStatus = invApprovalStatus;
        }
}
