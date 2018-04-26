package com.part.dataobject;

import com.part.vo.PageVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageVO page;

    public JobDOExample() {
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

    public void setPage(PageVO page) {
        this.page=page;
    }

    public PageVO getPage() {
        return page;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLessSalaryIsNull() {
            addCriterion("less_salary is null");
            return (Criteria) this;
        }

        public Criteria andLessSalaryIsNotNull() {
            addCriterion("less_salary is not null");
            return (Criteria) this;
        }

        public Criteria andLessSalaryEqualTo(Integer value) {
            addCriterion("less_salary =", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryNotEqualTo(Integer value) {
            addCriterion("less_salary <>", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryGreaterThan(Integer value) {
            addCriterion("less_salary >", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("less_salary >=", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryLessThan(Integer value) {
            addCriterion("less_salary <", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("less_salary <=", value, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryIn(List<Integer> values) {
            addCriterion("less_salary in", values, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryNotIn(List<Integer> values) {
            addCriterion("less_salary not in", values, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryBetween(Integer value1, Integer value2) {
            addCriterion("less_salary between", value1, value2, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andLessSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("less_salary not between", value1, value2, "lessSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryIsNull() {
            addCriterion("mast_salary is null");
            return (Criteria) this;
        }

        public Criteria andMastSalaryIsNotNull() {
            addCriterion("mast_salary is not null");
            return (Criteria) this;
        }

        public Criteria andMastSalaryEqualTo(Integer value) {
            addCriterion("mast_salary =", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryNotEqualTo(Integer value) {
            addCriterion("mast_salary <>", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryGreaterThan(Integer value) {
            addCriterion("mast_salary >", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("mast_salary >=", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryLessThan(Integer value) {
            addCriterion("mast_salary <", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("mast_salary <=", value, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryIn(List<Integer> values) {
            addCriterion("mast_salary in", values, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryNotIn(List<Integer> values) {
            addCriterion("mast_salary not in", values, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryBetween(Integer value1, Integer value2) {
            addCriterion("mast_salary between", value1, value2, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andMastSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("mast_salary not between", value1, value2, "mastSalary");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeIsNull() {
            addCriterion("salary_type is null");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeIsNotNull() {
            addCriterion("salary_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeEqualTo(Integer value) {
            addCriterion("salary_type =", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotEqualTo(Integer value) {
            addCriterion("salary_type <>", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeGreaterThan(Integer value) {
            addCriterion("salary_type >", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_type >=", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeLessThan(Integer value) {
            addCriterion("salary_type <", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("salary_type <=", value, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeIn(List<Integer> values) {
            addCriterion("salary_type in", values, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotIn(List<Integer> values) {
            addCriterion("salary_type not in", values, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeBetween(Integer value1, Integer value2) {
            addCriterion("salary_type between", value1, value2, "salaryType");
            return (Criteria) this;
        }

        public Criteria andSalaryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_type not between", value1, value2, "salaryType");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIsNull() {
            addCriterion("need_people is null");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIsNotNull() {
            addCriterion("need_people is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleEqualTo(Integer value) {
            addCriterion("need_people =", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotEqualTo(Integer value) {
            addCriterion("need_people <>", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleGreaterThan(Integer value) {
            addCriterion("need_people >", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_people >=", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleLessThan(Integer value) {
            addCriterion("need_people <", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("need_people <=", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIn(List<Integer> values) {
            addCriterion("need_people in", values, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotIn(List<Integer> values) {
            addCriterion("need_people not in", values, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleBetween(Integer value1, Integer value2) {
            addCriterion("need_people between", value1, value2, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("need_people not between", value1, value2, "needPeople");
            return (Criteria) this;
        }

        public Criteria andLessEducationIsNull() {
            addCriterion("less_education is null");
            return (Criteria) this;
        }

        public Criteria andLessEducationIsNotNull() {
            addCriterion("less_education is not null");
            return (Criteria) this;
        }

        public Criteria andLessEducationEqualTo(String value) {
            addCriterion("less_education =", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationNotEqualTo(String value) {
            addCriterion("less_education <>", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationGreaterThan(String value) {
            addCriterion("less_education >", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationGreaterThanOrEqualTo(String value) {
            addCriterion("less_education >=", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationLessThan(String value) {
            addCriterion("less_education <", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationLessThanOrEqualTo(String value) {
            addCriterion("less_education <=", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationLike(String value) {
            addCriterion("less_education like", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationNotLike(String value) {
            addCriterion("less_education not like", value, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationIn(List<String> values) {
            addCriterion("less_education in", values, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationNotIn(List<String> values) {
            addCriterion("less_education not in", values, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationBetween(String value1, String value2) {
            addCriterion("less_education between", value1, value2, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessEducationNotBetween(String value1, String value2) {
            addCriterion("less_education not between", value1, value2, "lessEducation");
            return (Criteria) this;
        }

        public Criteria andLessExperienceIsNull() {
            addCriterion("less_experience is null");
            return (Criteria) this;
        }

        public Criteria andLessExperienceIsNotNull() {
            addCriterion("less_experience is not null");
            return (Criteria) this;
        }

        public Criteria andLessExperienceEqualTo(String value) {
            addCriterion("less_experience =", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceNotEqualTo(String value) {
            addCriterion("less_experience <>", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceGreaterThan(String value) {
            addCriterion("less_experience >", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("less_experience >=", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceLessThan(String value) {
            addCriterion("less_experience <", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceLessThanOrEqualTo(String value) {
            addCriterion("less_experience <=", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceLike(String value) {
            addCriterion("less_experience like", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceNotLike(String value) {
            addCriterion("less_experience not like", value, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceIn(List<String> values) {
            addCriterion("less_experience in", values, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceNotIn(List<String> values) {
            addCriterion("less_experience not in", values, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceBetween(String value1, String value2) {
            addCriterion("less_experience between", value1, value2, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andLessExperienceNotBetween(String value1, String value2) {
            addCriterion("less_experience not between", value1, value2, "lessExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceIsNull() {
            addCriterion("mast_experience is null");
            return (Criteria) this;
        }

        public Criteria andMastExperienceIsNotNull() {
            addCriterion("mast_experience is not null");
            return (Criteria) this;
        }

        public Criteria andMastExperienceEqualTo(String value) {
            addCriterion("mast_experience =", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceNotEqualTo(String value) {
            addCriterion("mast_experience <>", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceGreaterThan(String value) {
            addCriterion("mast_experience >", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("mast_experience >=", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceLessThan(String value) {
            addCriterion("mast_experience <", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceLessThanOrEqualTo(String value) {
            addCriterion("mast_experience <=", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceLike(String value) {
            addCriterion("mast_experience like", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceNotLike(String value) {
            addCriterion("mast_experience not like", value, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceIn(List<String> values) {
            addCriterion("mast_experience in", values, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceNotIn(List<String> values) {
            addCriterion("mast_experience not in", values, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceBetween(String value1, String value2) {
            addCriterion("mast_experience between", value1, value2, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andMastExperienceNotBetween(String value1, String value2) {
            addCriterion("mast_experience not between", value1, value2, "mastExperience");
            return (Criteria) this;
        }

        public Criteria andLessAgeIsNull() {
            addCriterion("less_age is null");
            return (Criteria) this;
        }

        public Criteria andLessAgeIsNotNull() {
            addCriterion("less_age is not null");
            return (Criteria) this;
        }

        public Criteria andLessAgeEqualTo(Integer value) {
            addCriterion("less_age =", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeNotEqualTo(Integer value) {
            addCriterion("less_age <>", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeGreaterThan(Integer value) {
            addCriterion("less_age >", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("less_age >=", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeLessThan(Integer value) {
            addCriterion("less_age <", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeLessThanOrEqualTo(Integer value) {
            addCriterion("less_age <=", value, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeIn(List<Integer> values) {
            addCriterion("less_age in", values, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeNotIn(List<Integer> values) {
            addCriterion("less_age not in", values, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeBetween(Integer value1, Integer value2) {
            addCriterion("less_age between", value1, value2, "lessAge");
            return (Criteria) this;
        }

        public Criteria andLessAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("less_age not between", value1, value2, "lessAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeIsNull() {
            addCriterion("mast_age is null");
            return (Criteria) this;
        }

        public Criteria andMastAgeIsNotNull() {
            addCriterion("mast_age is not null");
            return (Criteria) this;
        }

        public Criteria andMastAgeEqualTo(Integer value) {
            addCriterion("mast_age =", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeNotEqualTo(Integer value) {
            addCriterion("mast_age <>", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeGreaterThan(Integer value) {
            addCriterion("mast_age >", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mast_age >=", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeLessThan(Integer value) {
            addCriterion("mast_age <", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeLessThanOrEqualTo(Integer value) {
            addCriterion("mast_age <=", value, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeIn(List<Integer> values) {
            addCriterion("mast_age in", values, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeNotIn(List<Integer> values) {
            addCriterion("mast_age not in", values, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeBetween(Integer value1, Integer value2) {
            addCriterion("mast_age between", value1, value2, "mastAge");
            return (Criteria) this;
        }

        public Criteria andMastAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("mast_age not between", value1, value2, "mastAge");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("telphone is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("telphone is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(Long value) {
            addCriterion("telphone =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(Long value) {
            addCriterion("telphone <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(Long value) {
            addCriterion("telphone >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(Long value) {
            addCriterion("telphone >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(Long value) {
            addCriterion("telphone <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(Long value) {
            addCriterion("telphone <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<Long> values) {
            addCriterion("telphone in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<Long> values) {
            addCriterion("telphone not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(Long value1, Long value2) {
            addCriterion("telphone between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(Long value1, Long value2) {
            addCriterion("telphone not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andConnectUserIsNull() {
            addCriterion("connect_user is null");
            return (Criteria) this;
        }

        public Criteria andConnectUserIsNotNull() {
            addCriterion("connect_user is not null");
            return (Criteria) this;
        }

        public Criteria andConnectUserEqualTo(String value) {
            addCriterion("connect_user =", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserNotEqualTo(String value) {
            addCriterion("connect_user <>", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserGreaterThan(String value) {
            addCriterion("connect_user >", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserGreaterThanOrEqualTo(String value) {
            addCriterion("connect_user >=", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserLessThan(String value) {
            addCriterion("connect_user <", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserLessThanOrEqualTo(String value) {
            addCriterion("connect_user <=", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserLike(String value) {
            addCriterion("connect_user like", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserNotLike(String value) {
            addCriterion("connect_user not like", value, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserIn(List<String> values) {
            addCriterion("connect_user in", values, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserNotIn(List<String> values) {
            addCriterion("connect_user not in", values, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserBetween(String value1, String value2) {
            addCriterion("connect_user between", value1, value2, "connectUser");
            return (Criteria) this;
        }

        public Criteria andConnectUserNotBetween(String value1, String value2) {
            addCriterion("connect_user not between", value1, value2, "connectUser");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailIsNull() {
            addCriterion("company_detail is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailIsNotNull() {
            addCriterion("company_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailEqualTo(String value) {
            addCriterion("company_detail =", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailNotEqualTo(String value) {
            addCriterion("company_detail <>", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailGreaterThan(String value) {
            addCriterion("company_detail >", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailGreaterThanOrEqualTo(String value) {
            addCriterion("company_detail >=", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailLessThan(String value) {
            addCriterion("company_detail <", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailLessThanOrEqualTo(String value) {
            addCriterion("company_detail <=", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailLike(String value) {
            addCriterion("company_detail like", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailNotLike(String value) {
            addCriterion("company_detail not like", value, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailIn(List<String> values) {
            addCriterion("company_detail in", values, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailNotIn(List<String> values) {
            addCriterion("company_detail not in", values, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailBetween(String value1, String value2) {
            addCriterion("company_detail between", value1, value2, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCompanyDetailNotBetween(String value1, String value2) {
            addCriterion("company_detail not between", value1, value2, "companyDetail");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andRequestLimitIsNull() {
            addCriterion("request_limit is null");
            return (Criteria) this;
        }

        public Criteria andRequestLimitIsNotNull() {
            addCriterion("request_limit is not null");
            return (Criteria) this;
        }

        public Criteria andRequestLimitEqualTo(String value) {
            addCriterion("request_limit =", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitNotEqualTo(String value) {
            addCriterion("request_limit <>", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitGreaterThan(String value) {
            addCriterion("request_limit >", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitGreaterThanOrEqualTo(String value) {
            addCriterion("request_limit >=", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitLessThan(String value) {
            addCriterion("request_limit <", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitLessThanOrEqualTo(String value) {
            addCriterion("request_limit <=", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitLike(String value) {
            addCriterion("request_limit like", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitNotLike(String value) {
            addCriterion("request_limit not like", value, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitIn(List<String> values) {
            addCriterion("request_limit in", values, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitNotIn(List<String> values) {
            addCriterion("request_limit not in", values, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitBetween(String value1, String value2) {
            addCriterion("request_limit between", value1, value2, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andRequestLimitNotBetween(String value1, String value2) {
            addCriterion("request_limit not between", value1, value2, "requestLimit");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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