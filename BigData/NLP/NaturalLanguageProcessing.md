# Tokenize (형태소 분석)
# POS Tagging (Part-of-speech, 품사표시)
# Stopwords 제거 (불용어 제거)

> 특수문자 제거
>
> 형태소 나누기
>
> 사전 원형으로 바꾸기
>
> 품사 기반으로 일부 품사의 형태소만 남기기
>
> 형태소 길이가 1을 초과하는 것만 남기기
> '배공빠르고 굿' -> ['배공', '빠르다', '굿']

# 단어 개수 카운팅 & 단어 사전 생성
- `from sklearn.feature_extraction.text import CountVectorizer`
- `from collections import Counter`
- `from tensorflow.keras.preprocessing.text import Tokenizer`

# 단어 사전 기반 데이터 시각화
# (+ 머신러닝/딥러닝 모델 적용)


# TF-IDF (단어출현빈도 - 역 문서에서의 출현빈도)
- $tf(d,t)$ : 단어의 빈도수
- $idf(d,t)$ : 역 문서에서의 출현빈도
- $n_d$ : 전체 문서의 수
- $df(t)$ : 단어 t를 가진 문서의 수

$$ tf-idf(d,t) = tf(d,t) * idf(d,t) $$

$$ idf(d,t) = \log{\frac{n_d}{1 + df(t)}}$$










