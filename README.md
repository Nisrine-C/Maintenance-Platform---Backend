# Maintenance-Platform---Backend
### **1. Domain Layer (Entities)**

```mermaid
erDiagram
MACHINE ||--o{ SENSOR_DATA : "1-to-many"
MACHINE ||--o{ MAINTENANCE : "1-to-many"
MACHINE ||--o{ PREDICTION : "1-to-many"
MACHINE ||--o{ FAILURE : "1-to-many"
USER ||--o{ MAINTENANCE : "1-to-many"
USER }|--|| ROLE : "many-to-one"

    MACHINE {
        bigint id PK
        varchar name
        date installation_date
    }
    SENSOR_DATA {
        bigint id PK
        float vibration_x
        float vibration_y
        timestamp recorded_at
        bigint machine_id FK
    }
    MAINTENANCE {
        bigint id PK
        timestamp action_date
        boolean is_preventive
        bigint machine_id FK
        bigint user_id FK
    }
    PREDICTION {
        bigint id PK
        float rul_hours
        float confidence
        varchar fault_type
        bigint machine_id FK
    }
```

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

