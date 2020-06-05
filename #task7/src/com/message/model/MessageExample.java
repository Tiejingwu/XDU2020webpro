package com.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(Integer value) {
            addCriterion("messageid =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(Integer value) {
            addCriterion("messageid <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(Integer value) {
            addCriterion("messageid >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageid >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(Integer value) {
            addCriterion("messageid <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("messageid <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<Integer> values) {
            addCriterion("messageid in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<Integer> values) {
            addCriterion("messageid not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(Integer value1, Integer value2) {
            addCriterion("messageid between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("messageid not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andReceiveidIsNull() {
            addCriterion("receiveid is null");
            return (Criteria) this;
        }

        public Criteria andReceiveidIsNotNull() {
            addCriterion("receiveid is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveidEqualTo(Integer value) {
            addCriterion("receiveid =", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidNotEqualTo(Integer value) {
            addCriterion("receiveid <>", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidGreaterThan(Integer value) {
            addCriterion("receiveid >", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiveid >=", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidLessThan(Integer value) {
            addCriterion("receiveid <", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidLessThanOrEqualTo(Integer value) {
            addCriterion("receiveid <=", value, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidIn(List<Integer> values) {
            addCriterion("receiveid in", values, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidNotIn(List<Integer> values) {
            addCriterion("receiveid not in", values, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidBetween(Integer value1, Integer value2) {
            addCriterion("receiveid between", value1, value2, "receiveid");
            return (Criteria) this;
        }

        public Criteria andReceiveidNotBetween(Integer value1, Integer value2) {
            addCriterion("receiveid not between", value1, value2, "receiveid");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNull() {
            addCriterion("senderid is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderid is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(Integer value) {
            addCriterion("senderid =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(Integer value) {
            addCriterion("senderid <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(Integer value) {
            addCriterion("senderid >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("senderid >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(Integer value) {
            addCriterion("senderid <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(Integer value) {
            addCriterion("senderid <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<Integer> values) {
            addCriterion("senderid in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<Integer> values) {
            addCriterion("senderid not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(Integer value1, Integer value2) {
            addCriterion("senderid between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("senderid not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIsNull() {
            addCriterion("messagetime is null");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIsNotNull() {
            addCriterion("messagetime is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetimeEqualTo(Date value) {
            addCriterion("messagetime =", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotEqualTo(Date value) {
            addCriterion("messagetime <>", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeGreaterThan(Date value) {
            addCriterion("messagetime >", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("messagetime >=", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeLessThan(Date value) {
            addCriterion("messagetime <", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeLessThanOrEqualTo(Date value) {
            addCriterion("messagetime <=", value, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeIn(List<Date> values) {
            addCriterion("messagetime in", values, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotIn(List<Date> values) {
            addCriterion("messagetime not in", values, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeBetween(Date value1, Date value2) {
            addCriterion("messagetime between", value1, value2, "messagetime");
            return (Criteria) this;
        }

        public Criteria andMessagetimeNotBetween(Date value1, Date value2) {
            addCriterion("messagetime not between", value1, value2, "messagetime");
            return (Criteria) this;
        }

        public Criteria andParentmessageidIsNull() {
            addCriterion("parentmessageid is null");
            return (Criteria) this;
        }

        public Criteria andParentmessageidIsNotNull() {
            addCriterion("parentmessageid is not null");
            return (Criteria) this;
        }

        public Criteria andParentmessageidEqualTo(Integer value) {
            addCriterion("parentmessageid =", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidNotEqualTo(Integer value) {
            addCriterion("parentmessageid <>", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidGreaterThan(Integer value) {
            addCriterion("parentmessageid >", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentmessageid >=", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidLessThan(Integer value) {
            addCriterion("parentmessageid <", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidLessThanOrEqualTo(Integer value) {
            addCriterion("parentmessageid <=", value, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidIn(List<Integer> values) {
            addCriterion("parentmessageid in", values, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidNotIn(List<Integer> values) {
            addCriterion("parentmessageid not in", values, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidBetween(Integer value1, Integer value2) {
            addCriterion("parentmessageid between", value1, value2, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andParentmessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentmessageid not between", value1, value2, "parentmessageid");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}