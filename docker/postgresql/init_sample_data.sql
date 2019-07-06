//TODO: Docker 컨테이너 생성시에 자동으로 생성해줄 수 있을지?
CREATE TABLE test (
  id SERIAL UNIQUE NOT NULL,
  code VARCHAR(10) NOT NULL,
  article TEXT,
  name TEXT NOT NULL
);

insert into test (
    code, article, name
)
select
    left(md5(i::text), 10),
    md5(random()::text),
    md5(random()::text)
from generate_series(1, 100) s(i)