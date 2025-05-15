# Maintenance-Platform---Backend
### **1. Domain Layer (Entities)**

````markdown
# DAO Layer Architecture

```mermaid
flowchart TB
    subgraph Repository_Layer
        A[MachineRepository] -->|findBySerialNumber| B[(Machines)]
        C[SensorDataRepository] -->|deleteByTimestampBefore| D[(SensorData)]
        E[MaintenanceRepository] -->|calculateTotalCost| F[(Maintenance)]
    end

    style A fill:#f9f,stroke:#333
    style C fill:#f9f,stroke:#333
    style E fill:#f9f,stroke:#333
    style B fill:#bbf,stroke:#333
    style D fill:#bbf,stroke:#333
    style F fill:#bbf,stroke:#333

### **2. Repository Layer**

```mermaid
flowchart TB
subgraph Repository_Layer
A[MachineRepository] -->|findBySerialNumber| B[(Machines)]
C[SensorDataRepository] -->|deleteByTimestampBefore| D[(SensorData)]
E[MaintenanceRepository] -->|calculateTotalCost| F[(Maintenance)]
end
```

**Key Operations**:
- Standard CRUD (Create, Read, Update, **Delete**)
- Custom queries (time-range filters, aggregates)
- Soft delete option available

