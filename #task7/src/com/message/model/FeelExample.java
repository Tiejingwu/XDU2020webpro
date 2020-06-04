package com.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeelExample() {
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

        public Criteria andFeelidIsNull() {
            addCriterion("feelid is null");
            return (Criteria) this;
        }

        public Criteria andFeelidIsNotNull() {
            addCriterion("feelid is not null");
            return (Criteria) this;
        }

        public Criteria andFeelidEqualTo(Integer value) {
            addCriterion("feelid =", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidNotEqualTo(Integer value) {
            addCriterion("feelid <>", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidGreaterThan(Integer value) {
            addCriterion("feelid >", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("feelid >=", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidLessThan(Integer value) {
            addCriterion("feelid <", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidLessThanOrEqualTo(Integer value) {
            addCriterion("feelid <=", value, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidIn(List<Integer> values) {
            addCriterion("feelid in", values, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidNotIn(List<Integer> values) {
            addCriterion("feelid not in", values, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidBetween(Integer value1, Integer value2) {
            addCriterion("feelid between", value1, value2, "feelid");
            return (Criteria) this;
        }

        public Criteria andFeelidNotBetween(Integer value1, Integer value2) {
            addCriterion("feelid not between", value1, value2, "feelid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andFeeltimeIsNull() {
            addCriterion("feeltime is null");
            return (Criteria) this;
        }

        public Criteria andFeeltimeIsNotNull() {
            addCriterion("feeltime is not null");
            return (Criteria) this;
        }

        public Criteria andFeeltimeEqualTo(Date value) {
            addCriterion("feeltime =", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeNotEqualTo(Date value) {
            addCriterion("feeltime <>", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeGreaterThan(Date value) {
            addCriterion("feeltime >", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feeltime >=", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeLessThan(Date value) {
            addCriterion("feeltime <", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeLessThanOrEqualTo(Date value) {
            addCriterion("feeltime <=", value, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeIn(List<Date> values) {
            addCriterion("feeltime in", values, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeNotIn(List<Date> values) {
            addCriterion("feeltime not in", values, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeBetween(Date value1, Date value2) {
            addCriterion("feeltime between", value1, value2, "feeltime");
            return (Criteria) this;
        }

        public Criteria andFeeltimeNotBetween(Date value1, Date value2) {
            addCriterion("feeltime not between", value1, value2, "feeltime");
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