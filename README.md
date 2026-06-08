#  SmartLedger 記帳系統（Java CLI）

#  專案介紹
SmartLedger 是一個以 Java 撰寫的終端機（CLI）記帳系統，  
提供基本的收入與支出管理功能，包含新增紀錄、統計分析、排序與搜尋等功能。

本專案應用本學期所學之：
- 物件導向（封裝、合成）
- 集合（ArrayList）
- 字串處理
- 搜尋與排序

---

#  組員名單
- 414630292洪誼蓁 
- 414630532劉芊鈺 
- 414630862黃玟瑄 
- 414631076沈楷惟 
- 414631134黃上恩 

---

#  開發動機

  現在日常生活中幾乎每天都會有各種開銷，但很多人其實沒有記帳的習慣，或是記了也不太會整理，久了就很難知道自己的錢到底花去哪裡。因此，我們想設計一個簡單好用的記帳系統，讓使用者可以快速記錄每一筆收入和支出，並透過系統幫忙整理與統計，清楚掌握自己的消費狀況。 
  另外，這次專題也希望能把這學期學到的內容實際應用出來，例如物件導向設計、ArrayList資料儲存、搜尋與排序等功能，透過實作一個完整的系統，加深對這些概念的理解。同時採用終端機文字介面，讓整體操作簡單直覺，也符合課程的實作要求。 

---

#  系統功能

 1️ Add a new record
- Enter date (YYYY/MM/DD)、type (Income/Expense)、amount、note

 2️ View all records
- All Records

 3 Income/Expense statistics
- Calculate Total Income、Total Expense、Balance

 4️ Sort by amount (High -> Low)

 5️ Search records by keyword

---

#  系統架構

#  類別說明

# `Item`
- 儲存單筆記帳資料
- 屬性：日期、類型、金額、備註
- 展現封裝概念

# `Ledger`
- 管理所有記帳資料（ArrayList）
- 提供新增、統計、排序、搜尋功能
- 展現合成概念

# `SmartLedger`
- 主程式（使用者介面）
- 負責輸入與選單操作

---
