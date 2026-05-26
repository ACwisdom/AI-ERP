# 简历 · 项目经历（STAR 法则）

> 项目名称可按投递岗位微调，例如：**摩托车零部件智能采购系统** / **AI+ERP 采购助手平台**

---

## 一、精简版（适合简历一栏，约 4～6 行）

**摩托车零部件智能采购系统（AI + ERP）**  
*Java · Spring Boot · MyBatis Plus · MySQL | Python · LangGraph · FastAPI · Vue 3 · MCP*

- **情境**：传统零部件采购依赖多系统查数、手工建单，供应商/库存/订单数据分散，业务人员难以快速完成查询分析与下单。
- **任务**：建设可支撑供应商、零部件、采购订单、库存、客户、物流全流程的 ERP 后端，并叠加自然语言交互层，实现「对话式查数、分析、建单」与关键操作可审批。
- **行动**：设计前后端分离架构——Spring Boot 提供 REST API 与数据初始化；FastMCP 将业务 API 封装为 Agent 工具；LangGraph 编排主 Agent 与采购分析/下单子 Agent；Vue3 实现流式对话与 HITL 中断恢复；MongoDB 持久化对话 checkpoint。
- **成果**：形成 Java 业务层 + MCP 桥接 + AI 前端的完整链路；覆盖 8 大业务模块与 30+ 样例数据维度；支持 Swagger 联调、MCP 工具化调用及聊天端一键启停，具备可演示的端到端智能采购场景。

---

## 二、标准 STAR 叙述（面试口述 / 项目详情页）

### S — 情境（Situation）

摩托车零部件采购涉及供应商评级、零部件分类、采购订单全生命周期、库存预警、客户与物流跟踪等环节。团队需要一套可演示、可扩展的采购管理系统，同时探索用大模型降低业务人员使用 ERP 的门槛，让非技术人员通过对话完成查询、分析与下单，而不是只在 Swagger 里调接口。

### T — 任务（Task）

1. 实现采购 ERP 核心能力：供应商、产品、订单、库存、客户、物流、统计等模块的 CRUD 与分页查询。  
2. 提供稳定 REST API 与数据库方案（MySQL），支持启动时自动建库、建表与样例数据灌入。  
3. 在 ERP 之上构建 AI 应用：多 Agent 协作、MCP 工具调用 Java API、流式对话前端、订单等敏感操作的 Human-in-the-Loop（HITL）审批。  
4. 打通部署与联调路径：Java（8080）、MCP（8000）、FastAPI（8090）、Vue（3000）分层可独立验证。

### A — 行动（Action）

| 模块 | 关键工作 |
|------|----------|
| **ERP 后端** | 基于 Spring Boot 2.7 + MyBatis Plus 设计 8 类 Controller/Service；统一 `Result`/`PageResult` 响应；Swagger 文档；`DatabaseInitializer` 自动初始化 `motorparts_db`（供应商约 30、产品约 60、订单约 120 等样例）。 |
| **MCP 桥接** | 使用 FastMCP 实现 `supplier_*` / `part_*` / `order_*` / `inventory_*` 工具组，HTTP 转发至 `localhost:8080/api`，供 LangGraph Agent 结构化调用。 |
| **智能体层** | LangGraph 主 Agent + 子 Agent（采购分析、下单）；`langchain-mcp-adapters` 聚合 ERP MCP 与图表 MCP；技能（Skills）同步至 OpenSandbox；对话状态 MongoDB checkpoint，支持中断后 `/resume` 恢复。 |
| **前端** | Vue 3 + Vite 聊天界面，SSE 流式展示；`InterruptBanner` 处理 HITL 审批与订单信息补全；FastAPI 提供会话、历史与文件下载接口。 |
| **工程化** | `start_web.py` 一键启前后端；采购相关 Skill（分析、比价爬取、供应商 URL 映射等）按业务域组织。 |

**技术栈汇总**：Spring Boot、MyBatis Plus、MySQL、Swagger · Python、LangGraph、FastAPI、FastMCP、Vue 3、MongoDB、OpenSandbox、DeepSeek/智谱等大模型 API

### R — 成果（Result）

- 交付 **「传统 ERP + AI Agent」双栈方案**：Java 项目可独立作为 API 型 ERP 运行；与 ERP_OPENCLAW 联调后形成完整智能采购演示链路。  
- **业务覆盖完整**：供应商 → 零部件 → 采购订单 → 库存 → 客户 → 物流 → 统计，满足课程/作品集级全流程演示需求。  
- **AI 能力可落地**：自然语言查询供应商与库存预警、辅助生成采购分析、下单流程支持中断审批与信息补全，降低 API 使用门槛。  
- **可扩展**：MCP 工具与 Java Controller 一一对应，新增业务只需扩展 REST + MCP 注册；子 Agent 与 Skills 配置化，便于按场景拆分能力。

---

## 三、分条 STAR  bullets（直接粘贴简历「项目经历」）

**摩托车零部件智能采购系统（AI + ERP）** | *核心开发*（角色请按实际情况改为「独立负责 / 参与」）  
*2024.xx – 2025.xx*（时间请自行填写）

1. **【S】** 针对零部件采购场景数据分散、操作链路长的问题，立项建设覆盖供应商、订单、库存、物流的 ERP 与对话式智能助手一体化方案。  
2. **【T】** 负责后端领域建模与 API 设计，并主导 AI 层架构（MCP 工具化、多 Agent、流式前端），目标实现「对话查数 + 分析 + 可控下单」。  
3. **【A】** 使用 Spring Boot + MyBatis Plus 实现 8 大业务模块与 MySQL 自动初始化；通过 FastMCP 将 REST 封装为 Agent 工具；基于 LangGraph 编排主/子 Agent，MongoDB 持久化会话，Vue3 实现 SSE 流式对话与 HITL 审批流。  
4. **【R】** 完成 Java（8080）+ MCP（8000）+ FastAPI/Vue（8090/3000）联调闭环；样例数据支撑供应商/产品/订单等多维演示；系统可作为 AI+ERP 集成类岗位的作品集与面试 Demo。

---

## 四、超短版（一行项目描述 + 三条 STAR 精简）

**摩托车零部件智能采购系统** — Spring Boot ERP + LangGraph 多 Agent 对话采购平台  

- **S/T**：采购业务需统一数据服务，并支持业务人员用自然语言完成查询、分析与下单。  
- **A**：自研 ERP REST 与 MCP 桥接；LangGraph + FastAPI + Vue 流式 HITL 前端；MySQL 全链路样例数据。  
- **R**：实现端到端智能采购 Demo，业务模块齐全、Agent 工具与 Java API 对齐，具备扩展与二次开发基础。

---

## 五、使用建议

1. **量化成果**：若你有真实 QPS、响应时间、用户数，把第四节「成果」中的「可演示」替换为具体数字（如「接口 P95 &lt; 200ms」「演示场景 15+」）。  
2. **角色诚实**：未参与的部分改为「参与 / 协作」，避免面试深挖时露馅。  
3. **岗位对齐**：投 **Java 后端** 侧重 Spring Boot、表设计、API；投 **AI 应用** 侧重 LangGraph、MCP、HITL；投 **全栈** 可保留双栈描述。  
4. **敏感信息**：简历中建议删除 `config.py` 内网 IP、API Key 等，仅写技术名称。

---

*根据仓库 `MotorcyclePartsProcurementSystem` + `ERP_OPENCLAW` 实际结构整理，可直接复制到简历「项目经历」栏目。*
