--------------------------------------------------------
--  File created - Friday-July-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BANKERS
--------------------------------------------------------

  CREATE TABLE "N01304773"."BANKERS" 
   (	"BANKER_ID" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "S19ITE5220ONAGURDEEP" ;
REM INSERTING into N01304773.BANKERS
SET DEFINE OFF;
Insert into N01304773.BANKERS (BANKER_ID,LASTNAME,FIRSTNAME) values ('banker','Wayne','Bruce');
--------------------------------------------------------
--  DDL for Index BANKERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "N01304773"."BANKERS_PK" ON "N01304773"."BANKERS" ("BANKER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "S19ITE5220ONAGURDEEP" ;
--------------------------------------------------------
--  Constraints for Table BANKERS
--------------------------------------------------------

  ALTER TABLE "N01304773"."BANKERS" ADD CONSTRAINT "BANKERS_PK" PRIMARY KEY ("BANKER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "S19ITE5220ONAGURDEEP"  ENABLE;
  ALTER TABLE "N01304773"."BANKERS" MODIFY ("BANKER_ID" NOT NULL ENABLE);
  ALTER TABLE "N01304773"."BANKERS" MODIFY ("LASTNAME" NOT NULL ENABLE);
  ALTER TABLE "N01304773"."BANKERS" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
