# Maintenance-Platform---Backend
### **1. Domain Layer (Entities)**

```markdown
```mermaid
flowchart TB
    subgraph Repository_Layer
        A[MachineRepository] -->|findBySerialNumber| B[(Machines)]
        C[SensorDataRepository] -->|deleteByTimestampBefore| D[(SensorData)]
        E[MaintenanceRepository] -->|calculateTotalCost| F[(Maintenance)]
    end
```

### **2. Repository Layer**

```markdown
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

